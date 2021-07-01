#%% İntro
sehir = "Ankara"

sonuc = sehir.upper() # print ile yazdırmadan da iş yapıyor. #konsolda gözükmüyor fakat variable explorerda iş yapıyor
#yani "return" etmiyor. Fonksiyonlar bu bakımdan ikiye ayrılıyor.
print(sehir.endswith("a")) # "andswith" fonksiyonu 
# ... ile bitiyor munun bilgisini verir true ya da false verir cevabı.

#%% Örnekler ve Detaylı Paremetre yapısı

def selamVer(isim = " default değer"):
    print("Merhaba" + isim)

selamVer(" Furkan")
selamVer() #boş bırakırsan defaul değer olarak yukarda yazılan verilir.

#%% dik üçgen alan hesaplama
def dikUcgenAlani(a,b):
    return a*b/2 #artık bir değer return ediyor.

alan = dikUcgenAlani(4,5)
print(alan)
# ya da
print(dikUcgenAlani(5,6))

#%% Lambda Fonksiyonları def ve return kombinasyonun
#tek fonksiyonda toplanmış hali

dikUcgenAlani2 = lambda a,b : a*b/2
#okunuşu; a ve b parametreleri için (:) a*b/2 formülünü return et.
print(dikUcgenAlani2(3, 6))












