#[derive(Debug)]
struct Person<'a> {
    name: &'a str,
    age: u8,
}

// Unit struct
struct Nil;

// Tuple struct
struct Pair(i32, f32);

struct Point {
    x: f32,
    y: f32,
}

#[allow(dead_code)]
struct Rectangle {
    p1: Point,
    p2: Point,
}

fn main() {
    let name = "Peter";
    let age = 27;
    let peter = Person { name, age };

    println!("{:?}", peter);

    let point: Point = Point { x: 0.3, y: 0.4 };
    println!("Point coordinates: ({}, {})", point.x, point.y);

    let new_point = Point { x: 0.1, ..point };
    println!("Second point coordinates: ({}, {})", new_point.x, new_point.y);

    let Point { x: my_x, y: my_y } = point;

    let _rectangle = Rectangle {
        p1: Point { x: my_y, y: my_x },
        p2: point,
    };

    let _nil = Nil;

    let pair = Pair(1, 0.1);
    println!("Pair contains {:?} and {:?}", pair.0, pair.1);

    let Pair(integer, decimal) = pair;
    println!("Pair contains {:?} and {:?}", integer, decimal);
}
