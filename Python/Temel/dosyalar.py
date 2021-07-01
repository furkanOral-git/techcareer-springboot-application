
f = open("musteriler.txt","r")
# w = üzerine yaz, r =read yani oku, a=append oku ve yaz, x = create oluştur demek.

print(f.readline(1))  #satır oku demek
print(f.read()) # ikisi iç içe kullanılmıyor çünkü önceden okuduğunu bir sonrakinde okumuyor.

f.close()

# Dosya yazma Dosya silme:

fileToAppend = open("ogrenciler.txt","a")
fileToAppend.write("Derin")
fileToAppend.write("\nSalih")   

fileToAppend.close()

import os #os modülümüz:
os.remove("ogrenciler.txt")#dosya silmemize yarayan fonksiyon

os.rmdir("empty")#klasör silmeye yarayan komut.


