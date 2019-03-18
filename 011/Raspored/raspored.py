import urllib.request

url = 'http://www.np.ac.rs/downloads/raspored_predavanja/l1819/sing.pdf'
urllib.request.urlretrieve(url, 'raspored.pdf')
