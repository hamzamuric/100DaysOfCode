use std::io;

fn main() {
    println!("Convert between Celsius and Fahrenheit");
    println!("1. C -> F\n2. F -> C");

    let mut choice = String::new();
    io::stdin().read_line(&mut choice).unwrap();

    let choice: u8 = choice.trim().parse().unwrap();

    println!("Enter temperature: ");
    let mut temp = String::new();
    io::stdin().read_line(&mut temp).unwrap();

    let temp: f64 = temp.trim().parse().unwrap();

    let result = match choice {
        1 => temp * 9.0 / 5.0 + 32.0,
        2 => (temp - 32.0) * 5.0 / 9.0,
        _ => 0f64,
    };

    println!("Result: {}", result);
}
