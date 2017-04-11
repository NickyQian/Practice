package com.nicky.reversepolish;

/*
 * Scan the Infix string from left to right.
 * Initialise an empty stack.
 * If the scannned character is an operand, add it to the Postfix string. If the scanned character is an operator and if the stack is empty Push the character tostack.
 * If the scanned character is an Operand and the stack is not empty, compare the precedence of the character with the element on top of the stack(topStack). 
 * If top Stack has higher precedence over the scanned character Pop the stack else Push the scanned character to stack. Repeat this step as long as stack is not empty and topStack has precedence over the character.
 * Repeat this step till all the characters are scanned.
 * (After all characters are scanned, we have to add any character that the stack may have to the Postfix string.) If stack is not empty add topStack to Postfix stringand Pop the stack. Repeat this step as long as stack is not empty.
 * Return the Postfix string.
 */
public interface InfixToPostFix {
	public String convertToPostFix(String infix);
}
