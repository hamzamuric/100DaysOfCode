use std::collections::HashMap;

fn main() {
    let mut list = vec![6, 4, 2, 2, 4, 7, 8, 2, 4, 0, 9, 1, 6];
    let mut frequency = HashMap::new();
    let mut sum = 0;

    list.sort();

    for num in &list {
        let count = frequency.entry(num).or_insert(0);
        *count += 1;
        sum += num;
    }

    let mut _mod = 0;
    for (k, v) in frequency.iter() {
        if v > frequency.get(&_mod).unwrap() {
            _mod = **k;
        }
    }

    println!("Mean is {:.3}", sum as f64 / list.len() as f64);
    println!("Median is {}", list.get(list.len() / 2).unwrap());
    println!("Mod is {}", _mod);
}
