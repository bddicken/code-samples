#!/usr/bin/python

import sys
from random import randint

num = randint(1,100)

if num > 50:
    exec "print \"More than 50\"\n"
else:
    exec "print \"Less than 50\"\n"

