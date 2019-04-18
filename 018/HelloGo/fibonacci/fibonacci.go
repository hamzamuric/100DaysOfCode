package main

import (
	"fmt"
)

func fib(n int) int {
	a := 0
	b := 1
	for i := 0; i < n; i++ {
		tmp := a
		a = b
		b = b + tmp
	}
	return b
}

func main() {
	for i := 0; i < 15; i++ {
		fmt.Println(fib(i))
	}
}

