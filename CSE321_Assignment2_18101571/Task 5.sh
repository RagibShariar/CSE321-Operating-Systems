#!/bin/bash

echo "Enter a number :"
read num

while [ $num > 0 ]
do
  sum=0  
  rem=$(( $rem%10 ))
  sum=$(( $sum+$num%10**2 ))
  num=$(( $num/10 ))
  if [ $sum <= 0 && $sum > 9 ];
  then 
    num=$sum
    sum=0
  fi 
done  
if [ $num == 1 ];then
  echo "$num is a happy number"
elif [ $num == 4 ];then
  echo "$num is a unhappy number" 
else
  echo "Ignore"
fi           