#!/bin/bash
echo "Enter a number :"
read num


if [ `expr $num % 2` == 0 ] || [ `expr $num % 5` == 0 ];
  then echo "Yes"
  if [ `expr $num % 2` == 0 ] && [ `expr $num % 5` == 0 ];
    then echo "No"  
  fi 
else 
  echo "Ignore"
fi
