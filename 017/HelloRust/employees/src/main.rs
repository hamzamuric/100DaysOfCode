extern crate regex;

use std::io;
use std::collections::HashMap;
use regex::Regex;

fn main() {
    let mut company = HashMap::new();
    let mut input = String::new();
    let stdin = io::stdin();
    let add = Regex::new(r"[Aa]dd \w+ to \w+\n?").unwrap();
    let read = Regex::new(r"[Rr]ead \w+\n?").unwrap();
   
    println!("input> ");
    stdin.read_line(&mut input).unwrap();

    let words: Vec<&str> = input.split(' ').collect();
    
    if add.is_match(&input) {
        let list = company.entry(words[3]).or_insert(Vec::new());
        list.push(words[1]);
    } else if read.is_match(&input) {
        if words[1] == "company" {
            println!("Listing company:");
            list_company(&company);
        } else {
            println!("Listing department {}", words[1]);
            list_department(&company.get(words[1]).unwrap());
        }
    }
}

fn list_department(list: &Vec<&str>) {
    for name in list.iter() {
        println!("{}", name);
    }
}

fn list_company(company: &HashMap<&str, Vec<&str>>) {
    for (department, list) in company.iter() {
        println!("Department {}", department);
        list_department(&list);
    }
}
