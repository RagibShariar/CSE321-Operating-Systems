#!/bin/bash
echo "Which operation would you like to do?"
read n 

echo "Operand 1: "
read num1
echo "Operand 2:"
read num2


case $n in 
  "+") echo "The result is $(($num1 + $num2 ))";;
  "-") echo "The result is $(($num1 - $num2 ))";;
  "*") echo "The result is $(($num1 * $num2 ))";;
  "/") echo "The result is $(($num1 / $num2 ))";;
  *)
esac