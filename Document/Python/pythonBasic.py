#!/home/lq00863/python3/bin python3
#-*- coding: utf-8 -*-
test1 = [0,1,2,3]
test2 = [4]
print(test1 + test2)
print(test2 + test1)
print(range(9))
print('Hello World')
print('\u4e2d\u6587')
print('ABC'.encode('utf-8'))
print('Hello, %s, %d%%! Python Rock!'%('Nick',100))
classmates = ['Nick1','Nick2','Nick3']
print(len(classmates))
print(classmates[0])
classmates.append('Nick4')
print(classmates)
age = 20
if age >= 20:
    print('your age is', age)
age = input('age: ')
ageInt = int(age)
if ageInt < 20:
	print('You are too young!')
	tupleTest = (1,2,3,'str')
	print(tupleTest)
else:
	print('nice')
sum = 0
for x in range(101):
	sum = sum + x
print('Sum(1~100):', sum)
dict = {'Nick1': 10, 'Nick2': 20, 'Nick3': 30}
print('Nick3:', dict['Nick3'])
if 'Nick2' in dict:
	print('Nick2 is in dict:', dict)

def my_abs(x):
	if x >= 0:
		return x
	else:
		return -x
print('my_abs(-100) :', my_abs(-100))
def getSum(*num):
	sum = 0
	for i in num:
		sum = sum + i
	return sum
print('sum is :', getSum(1,2,3,4))
listSum = [1,2,3,4]
print('list sum is: ', getSum(*listSum))
def fact(n):
	if n==1:
		return 1
	return n * fact(n-1)
print('fact(100):', fact(100))
