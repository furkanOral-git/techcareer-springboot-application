mesaj = "Merhaba Dünya dadadsadagfskdlfhsıfdffkjnbsbbjfnjfn"
# M=0 e=1 r=2 ... şeklinde sıralanırlar
#"sub" bir kısmını almak demek
print(mesaj[2:5])
print(mesaj[0:8])
yeniMesaj = mesaj[0:8] #değişken atama yöntemi
# ":" ibaresi ...den sonrasını ver demek.
print(mesaj[0:])
print(mesaj[:8]) #şimdi de öncesini aldık ":"işaretiyle
# yaptığımız işleme "substring" denir.

#-------------------------------------------

print(len(mesaj))
 # print(len(mesaj)) kod yazarken kodun sola yaslı olduğundan emin ol!!

yeniMesaj2 = mesaj[len(mesaj)-1:len(mesaj)]
yeniMesaj3 = mesaj[49:50]
print(yeniMesaj2)
print(yeniMesaj3)

# "Lower" "upper"
print(mesaj.upper()) #Bütün karakterleri büyütür.
print(mesaj.lower()) #Bütün karakterleri küçültür.
print(mesaj.lower())
# "Replace" fonksiyonu str değişkenin üstünde 
#değişiklik yapmamızı sağlıyor.
print(mesaj.replace("a", "v"))
print(mesaj)
newMassege = mesaj.replace("a", "v")
print(newMassege)

#split ve strip
bilgi = "Furkan Oral 20 Balıkesir"

print(bilgi.split())
print(bilgi.strip(" "))
print("Adı = " + bilgi.split(" ")[0])

veriTabanı = bilgi.split()[0] + bilgi.split()[1] + bilgi.split()[2] + bilgi.split()[3]
print(veriTabanı)










