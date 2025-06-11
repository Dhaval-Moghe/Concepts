# bitwise
use of different bitwise operator
it doesnt matter for positive numbers whether signed or unsigned shift is applied however makes a huge difference for negative number.

x = 1111 1111 1111 1111 1111 1111 1110 1100  (-20 in two's complement)

A) Signed Right Shift (x >> 2)
- Preserves the sign bit (keeps 1 if the number is negative).
- Shifts bits right by 2 places:
1111 1111 1111 1111 1111 1111 1111 1011  (Result after `x >> 2`) which is -5 

  - Output in decimal: -5 ✔ Used for arithmetic right shifts, ensuring the number remains negative if originally negative.

B) Unsigned Right Shift (x >>> 2)
- Fills left bits with 0, treating x as an unsigned number.
- Shifts bits right by 2 places:
0011 1111 1111 1111 1111 1111 1111 1011  (Result after `x >>> 2`) which is 1073741819

the same effect is not seen in positive number 
0000 0000 0000 0000 0000 0000 0001 0100 such as +20 
Signed Right Shift (x >> 2)
- Moves all bits two places to the right.
- The leftmost bits (sign bits) are filled with 0 (since the number is positive).
Step-by-step transformation:
Original:     0000 0000 0000 0000 0000 0000 0001 0100  (20)
Shift >> 2:   0000 0000 0000 0000 0000 0000 0000 0101  (5)

Unsigned Right Shift (x >>> 2)
- Also moves bits two places right, but it always fills left bits with 0, regardless of the original sign.
- Since 20 is already positive, there is no difference between >> and >>> in this case.
Step-by-step transformation:
Original:     0000 0000 0000 0000 0000 0000 0001 0100  (20)
Shift >>> 2:  0000 0000 0000 0000 0000 0000 0000 0101  (5)
