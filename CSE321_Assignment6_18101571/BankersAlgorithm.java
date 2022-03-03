import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BankersAlgorithm
{
    static int noOfProcess;
    static int noOfResources;

    static int[] available;
    static int[][] allocation;
    static int[][] max;

    static int[][] need;
    static int[][] work;
    static ArrayList<String> strings = new ArrayList<>();
    static ArrayList<Integer> seq = new ArrayList<>();

    static int counter = 0;

    public static void main(String[] a)
    {
        File file = new File("C:\\Users\\pc\\Desktop\\Bankers_Algorithm\\input.txt");
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(file);
            while (scanner.hasNext())
            {
                String _s = scanner.nextLine();
                if (!_s.isEmpty())
                {
                    strings.add(_s);
                }
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        for (int i = 0; i < strings.size(); i++)
        {
            if (i == 0)
            {
                noOfProcess = Integer.parseInt(strings.get(i));
            } else if (i == 1)
            {
                noOfResources = Integer.parseInt(strings.get(i));
                allocation = new int[noOfProcess][noOfResources];
                max = new int[noOfProcess][noOfResources];
                available = new int[noOfResources];
                need = new int[noOfProcess][noOfResources];
                work = new int[noOfProcess][noOfResources];

            } else
            {
                String _s = strings.get(i);

                if (i >= 2 && i <= 1 + noOfProcess)
                {
                    if (i == 2)
                        counter = 0;
                    StringTokenizer stringTokenizer = new StringTokenizer(_s, " ");
                    for (int k = 0; k < max[counter].length; k++)
                    {
                        max[counter][k] = Integer.parseInt(stringTokenizer.nextToken());
                    }
                    counter++;
                } else if (i >= 2 + noOfProcess && i < (2 * noOfProcess) + 2)
                {
                    if (counter == noOfProcess)
                        counter = 0;
                    StringTokenizer stringTokenizer = new StringTokenizer(_s, " ");
                    for (int k = 0; k < allocation[counter].length; k++)
                    {
                        allocation[counter][k] = Integer.parseInt(stringTokenizer.nextToken());
                    }
                    counter++;
                } else
                {
                    StringTokenizer stringTokenizer = new StringTokenizer(_s, " ");
                    for (int k = 0; k < available.length; k++)
                    {
                        String ts = stringTokenizer.nextToken();
                        available[k] = Integer.parseInt(ts);

                    }
                }

            }
        }

        for (int x = 0; x < need.length; x++)
        {
            for (int y = 0; y < need[x].length; y++)
            {
                need[x][y] = max[x][y] - allocation[x][y];
            }
        }
        System.out.println("Need Matrix:");
        for (int[] aNeed : need)
        {
            for (int anANeed : aNeed)
            {
                System.out.print(anANeed + " ");
            }
            System.out.println();
        }

        int work_counter = 0;
        for (int _x = 0; seq.size() < noOfProcess; _x = (_x + 1) % noOfProcess)
        {
            int match = 0;
            for (int y = 0; y < need[_x].length; y++)
            {
                if (need[_x][y] <= available[y])
                {
                    match++;
                }
            }
            int f = 0;
            for (Integer aSeq : seq)
            {
                if (_x == aSeq)
                {
                    f = 1;
                    break;
                }
            }

            if (match == noOfResources && f == 0)
            {
                seq.add(_x);
                for (int y = 0; y < need[_x].length; y++)
                {
                    work[work_counter][y] = allocation[_x][y] + available[y];
                    available[y] = work[work_counter][y];
                }
                work_counter++;
            }
        }

        System.out.println("sequence: ");
        for (int s : seq)
            System.out.println((char) (s + 65));
        System.out.println("Change in available resource matrix:");

        for (int[] aWork : work)
        {
            for (int anAWork : aWork)
            {
                System.out.print(anAWork + " ");
            }
            System.out.println();
        }
    }
}