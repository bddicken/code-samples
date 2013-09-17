This program was written to test the `likely()` and `unlikely()` compiler hints supported in some C compilers. It turns out that using these hints does not work all that well as I was hoping, most likely due to the fact that modern branch prediction is already really good at what it does.

Usage:

```
./test [likely, unlikely, normal] [loop iterations]
```

for example, to run a loop 10,000 times using the `likely()` compiler hint on every iteration, run:

```
./test likely 10000
```

