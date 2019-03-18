python3 raspored.py
md5sum raspored.pdf > new_hash
if ! diff old_hash new_hash
then
	cat new_hash > old_hash
	echo nisu isti
else
	echo isti su
fi
