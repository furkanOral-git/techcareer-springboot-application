# -*- coding: utf-8 -*-
#DİCTİONARY
#key:words ilişkisi anahtar:kelime
# aynen set gibi sırasız veri tutar
# günlük hayattaki sözcükler gibi düşünebiliriz
# {} parantezlerle gösterilir.

sozluk = {"book" : "kitap", 
  "table" : "masa"}
#constructor
sozluk2 = dict(kitap = "book" , masa = "table")
print(sozluk2)

print(sozluk)
sozluk["book"] = "kitap 1" #değiştirme komutu
sozluk["pencil"] = "kalem" #ekleme komutu
print(sozluk)
sozluk["table"] = "masa 1" #değiştirme komutu
print(sozluk)
del(sozluk["book"]) #silme komutu
print(sozluk)

