#!/bin/bash
echo "Enter your annual income:"
read income

x=0.1
y=0.2
z=0.3

if [ $income -le 240000 ];then
  a = $(( $income - $income ))
  echo $a
elif [ $income -le 540000 ];then  
  t = $(( $income - 240000 ))  
  a = $(( $t * $x ))
  echo $a 
elif[$income -le 720000 ];then
  t = $(( $income - 540000 ))
  tx1 = $(( 300000 * $x ))
  tx2 = $(( $t * $y ))
  tax = $(( $tx1 + $tx2 ))
  echo $tax
else   
  t = $(( $income - 720000 ))
  tx1 = $(( 300000 * $x ))  
  tx2 = $(( 180000 * $y ))  
  tx3 = $(( $t * $z ))  
  tax = $(( $tx1 + $tx2 + $tx3 ))  
  echo $tax
fi