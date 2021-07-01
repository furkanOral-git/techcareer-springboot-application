# -*- coding: utf-8 -*-

ogrenci1 = "Engin"
ogrenci2 = "Derin" 
ogrenci3 = "Salih"

print("Engin")
print("Derin")
print("Salih")

ogrenciler = ["Engin","Derin","Salih"]
#append ve remove
print(ogrenciler[1])
ogrenciler.append("Ahmet") #append listeye ekleme komutu

ogrenciler.remove("Salih") #remove listeden elaman çıkarma


print(ogrenciler)

#list constructor
sehirler = list(("Ankara","İstanbul","Ankara"))

print(len(sehirler))

#diğer fonksiyonlar
# print(sehirler.clear()) #clear listeyi temizler
print("Ankara Sayısı = " + str(sehirler.count("Ankara"))) #kaç tane Ankara var? sorusuna cevap.

#index seçtiğimiz eleman kaçıncı sırada bunu verir ve ilk bulduğuyla hemen işlemi bitirir.
print("Ankara indexi = " + str(sehirler.index("Ankara")))

#pop indexe göre elaman çıkarır. örn sehirler[1] yani İstanbul çıkartılır.
print(sehirler.pop(1))

#insert indexe göre yerleştirir kaçıncı sıraya yerleştirmek istiyorsak.
sehirler.insert(0,"Bursa")
#reverse terse çevirmedir.
sehirler.reverse()


print(sehirler)
#extend komutu *iki listeyi diziyi* birleştirir.

sehirler1 = list(("Mardin","Trabzon","Çanakkale"))
print(sehirler)
print(sehirler1)

sehirler1.extend(sehirler)
print(sehirler1)
#sort a-z ye sıralamayı sağlar.
sehirler1.sort()
sehirler1.reverse()

print(sehirler1)





