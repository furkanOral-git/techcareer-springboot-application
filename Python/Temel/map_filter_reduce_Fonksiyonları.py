

sayilar = [1,2,3,4,5]#burdaki datayı başka bir
#listeye "mapping" etmek istiyorum yani taşımak.
#ama mesela karesini alarak. uhuuuu:)

sayilarKareli = []

for sayi in sayilar :
    sayilarKareli.append(sayi*sayi)

print(sayilarKareli)

#%% Map fonksiyonu: mapping ile nasıl yapılır.

sayilar = [1,2,3,4,5]
sayilarKareli = list(map(lambda sayi: sayi**2,sayilar))
print(sayilarKareli)


#%% Filter Fonksiyonu:

sayilar = [1,2,3,4,5]

sayilarFitreli = list(filter(lambda sayi: sayi>2,sayilar))

print(sayilarFitreli)
#%% Reduce Fonksiyonu:kümülatif işlem yapmamızı sağlar.direkt çarpıyor.

sayilar = [1,2,3,4,5]    
from functools import reduce
sayilarFaktoriyel = reduce(lambda x,y:x*y,sayilar)
print(sayilarFaktoriyel)
# x ilk eleman y ise ikinci eleman oluyor ve her bir çarpma işleminin sonucunu
#1.eleman kabul ederek devam ediyor.


