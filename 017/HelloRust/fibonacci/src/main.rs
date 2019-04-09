use std::io;

fn main() {
    println!("N-th FIbonacci number");
    println!("Enter N:");

    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();

    let input: u32 = match input.trim().parse() {
        Ok(num) => num,
        Err(_) => 1,
    };

    let mut a: u128 = 1;
    let mut b: u128 = 1;

    for _ in 1 .. input {
        let tmp = b;
        b = a + b;
        a = tmp;
    }

    println!("result: {}", a);
    println!("result_recursive: {}", fib(input));
}

fn fib(n: u32) -> u64 {
    if n == 1 || n == 2 {
        return 1;
    }
    fib(n - 1) + fib(n - 2)
}