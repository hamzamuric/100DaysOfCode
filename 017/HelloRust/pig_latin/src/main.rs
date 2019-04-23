use std::io;

fn main() {
    let mut input = String::new();
    
    println!("Enter a word: ");
    io::stdin().read_line(&mut input).unwrap();

    let first_char = input.chars().nth(0).unwrap();

    match first_char {
        'a' | 'e' | 'i' | 'o' | 'u' =>
            println!("{}-hay", &input[..input.len() - 1]),
        chr  =>
            println!("{}-{}ay", &input[1..input.len() - 1], chr),
    }
}
