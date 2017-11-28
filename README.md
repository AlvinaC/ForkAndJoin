# ForkAndJoin
Demonstrates usage of # ForkAndJoinPool in Java

A new type of computer game is launched in the market, which requires a special type of gaming console. Makers of the games has made a new generation gaming console with a very unique remote.
 
The keys/layout of remote is as shown below

![ScreenShot](https://raw.githubusercontent.com/AlvinaC/ForkAndJoin/master/screenshot/screenshot_scenario1.png)

This remote contains 12 keys with 2 nonfunctional keys. Each functional key has been given a unique label as shown above.
The Computer game for this console has N levels. There are certain moves in the game which are controlled using the remote. The keys for each moves changes with the number of levels i.e. number of keys for an operation is dependent on the game level, for example, for third level, single move require three key [you have to press three keys in sequence for a move in third level]. A player can only press keys that are left, right, up or down to the current key and he is not allowed to press bottom row corner keys.
 
Suppose a player is at level 2. According to the rules he has to press 2 keys for a move (the number of keys is equal to the level). The possible Moves key will be HH , HI , HG , HE , HJ , IF ,.. etc

1. If a Move start from J , possible keys are JJ , JH (count 2) 
2. If a Move start from H , possible keys are HH , HI , HG , HE , HJ (count 5) 
3. If a Move start from I , possible keys are II , IH , IF (count 3) 
-------------------------- 

So for level 2, number of possible moves would be 36.
 
If a player is at level N, you have to find the total possible number of moves for that level.


Input Format
You will be given a function containing an integer N as argument representing the level of the game.

Output Format
You need to return an integer M, which is the total number of moves.


