fn largest<T: PartialOrd>(list: &[T]) -> &T {
    let mut max = &list[0];
    
    for i in list.iter() {
        if i > max {
            max = i;
        }
    }

    max
}

fn main() {
    let list_num = vec![3, 2, 7, 4, 55, 12, 9, 17, 44, 31];

    let max_num = largest(&list_num);

    let list_char = vec!['a', 'm', 'x', 'v', 'f', 'g'];

    let max_char = largest(&list_char);

    println!("largest element of list {:?} is {}", list_num, max_num);
    println!("largest element of list {:?} is {}", list_char, max_char);

}
