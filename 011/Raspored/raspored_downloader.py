from bs4 import BeautifulSoup
import requests
import urllib

url = 'http://www.np.ac.rs/yu/raspored-predavanja-teh'
r = requests.get(url)
soup = BeautifulSoup(r.text, 'html.parser')

container = soup.find_all('div', {'class': 'highslide-gallery'})[0]
links = container.find_all('a')

for link in links:
    if link.text == 'Softversko inženjersvo':
        path = link['href']

full_url = 'http://www.np.ac.rs' + path
urllib.request.urlretrieve(full_url, 'raspored.pdf')
