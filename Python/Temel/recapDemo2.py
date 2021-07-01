#%% Yıldız Sayısı Recap
yıldizSayisi = int(input("Kaç Yıldız Olsun ?"))
yıldiz = ""
for x in range(1,yıldizSayisi + 1) :
        yıldiz = yıldiz + "*"
        print(yıldiz)

#%% Asal Sayı Hesaplama Recap

sayi = int(input("Sayı Giriniz : "))
asalMi = "evet" #true ya da false kullanılabilir.
for x in range(2,sayi):
    if sayi % x == 0 :
        asalMi = "hayir"        
        break   
if asalMi =="evet":
    print("Asal")
else:
    print("Asal Değil")    
    
#%% Bölme İşlemi ********
sayi1 = int(input("Sayı 1 = "))    
sayi2 = int(input("Sayı 2 = "))

x = sayi1 % sayi2 # Mod döngüsü "%" ile gösteriliyo yani sonuç kalan gösteriliyo.
print("Kalan = " + str(x))
x = sayi1 / sayi2 # "/" ile Bölme işlemindeki Bölüm sonuç olarak gösteriliyo.
print("Bölüm = " + str(x))


