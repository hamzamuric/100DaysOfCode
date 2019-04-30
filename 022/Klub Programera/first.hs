// Zadatak 1
reverse' :: [a] -> [a]
reverse' [] = []
reverse' (x:xs) = reverse' xs ++ [x]

// Zadatak 2
unique' :: (Eq a) => [a] -> [a]
unique' [] = []
unique' (x:xs) = x : unique' (filter ((/=) x) xs)

// Zadatak 3
allunique' :: (Eq a) => [a] -> Bool
allunique' [] = True
allunique' (x:xs) = notElem x xs && allunique' xs
