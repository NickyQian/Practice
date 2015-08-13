#Slice
L = ['Michael','Sarah','Tracy','Tracy','Bob']
print('slice L[0:3]:', L[0:3])
sliceList = list(range(100))
print('slice list[0:20:2]', sliceList[0:20:2])
str='abcdefghijk'
print('slice str \'abcdefghijk\'[:3]', str[:3])
dict={'Nick1':1, 'Nick2':2}
for k, v in dict.items():
	print('key-value: %s : %s'%(k,v))
from collections import Iterable
print(isinstance('abc', Iterable))
#List Comprehensions
listCompre = [x*x for x in range(0,11) if x % 2 == 0 ]
print('list comprehensions, [x*x for x in range(0,11) if x % 2 ==0 ]:', listCompre)

import os
s = [d for d in os.listdir('../')]
print(s)

#Generator: call next() method every iterate, and return when encountered 'yield'
def fib(max):
	n,a,b=0,0,1
	while n < max:
		yield b
		a,b = b, a+b
		n = n+1
	return 'done'

f = fib(6)
print(f)

def odd():
	print('step 1')
	yield 1
	print('step 2')
	yield 3
	print('step 3')
	yield 5
o = odd()
print(next(o))
print(next(o))
print(next(o))

def triangles():
	l = [1]
	pos = 1
	yield l
	while True:
		a = [0] + l
		b = l + [0]
		pos = pos + 1
		l = [a[i]+b[i] for i in range(pos)]
		yield l

def triangles2():
	l = []
	while True:
		n = 1
		px = 1
		for x in l[1:]:
			l[n] = px + x
			px = x
			n = n + 1
		l.append(1)
		yield l	

def printTriangles(d):
	n = 0
	for t in d:
		print(t)
		n = n + 1 
		if n== 10:
			break
myPrint = printTriangles
myPrint(triangles())
tr2 = triangles2()
myPrint(tr2)

def testSlice():
	l = []
	for x in l[0:]:
		print('...')
	print('done')
testSlice()
testSliceList = [1,2]
print(testSliceList[1:])
print(testSliceList[0:])
print(testSliceList[2:])
def firstUpper(name):
	L=[name[0].upper()] 
	for x in name[1:]:
		L.append(x.lower())
	return ''.join(L)
print(firstUpper('meeee'))

def normalize(name):
	return list(map(firstUpper, name))

print(normalize(['nick','SDFSDF','ASIDF','sdfsdf']))

print('========sort=====')
print(sorted([26, 5, -12, 9, -21]))
a , b, c  = [1,2,3]
print('%s, %s, %s'%(a,b,c))
f = lambda x : x*x
print(f(2))
print(f.__name__)

#Decorator
def log(func):
	def wrapper(*args, **kw):
		print('call %s'%func.__name__)
		return func(*args, **kw)
	return wrapper

print(log(f)(1))
@log
def now():
	print('2015-08-13')
x = now
log(x)()
x()































