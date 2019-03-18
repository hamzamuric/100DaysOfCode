#!/usr/bin/env bash
venv/bin/python raspored_downloader.py
md5sum raspored.pdf > new_hash
if ! diff old_hash new_hash
then
	cat new_hash > old_hash
	cp raspored.pdf $HOME/Desktop/novi_raspored.pdf
	echo nisu isti
else
	echo isti su
fi
