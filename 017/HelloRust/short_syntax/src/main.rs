fn main() {
    // Python:
    // nums = [x for x in range(100)]

    // Rust:
    let nums: Vec<_> = (0..100).collect();

    for num in nums {
        println!("{}", num);
    }
}


