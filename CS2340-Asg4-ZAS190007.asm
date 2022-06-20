# Written by Zane Sanchez for CS 2340, Assignment 4, starting March 21, 2022.
# NetID: ZAS190007
# Program reads in a word and determines if it is a palindrome or not
.include "SysCalls.asm"

.data
word:			.space 256
word2: 			.space 256
prompt:			.asciiz "Enter word name: "
prompt1:		.asciiz "Not a palindrome" 
prompt2:		.asciiz  "Palindrome" 	
newLine:		.asciiz "\n"

.text

main:
	li $v0, SysPrintString			# Prompts User for input
	la $a0, prompt
	syscall
	
	li $v0, SysReadString 			# reads input
	la $a0, word				# stores input in word
	li $a1, 256				# max character to read in
	syscall
	
	li $v0, SysPrintString			# prints new line
	la $a0, newLine	
	syscall
	
	jal wordLength				# gets word length
	jal Upper				# converts to uppercase
	jal Clean				# removes non digits and letters
	jal Compare				# checks if palindrome
	j exit
	
.include "functions.asm"
