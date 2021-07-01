#benzer işlemleri belirli bir şarta göre 
#tekrarlamak için kullanılır.

sehirler = ["Ankara","İstanbul","İzmir"]
# print(sehirler[0])
# print(sehirler[1])
# print(sehirler[2])
        # *
        # *
        # *
#%% For İntro
sehirler = ["Ankara","İstanbul","İzmir"]

for sehir in sehirler: #sehirler içindeki her bir sehir için
    if sehir == "İstanbul" : # "!=" eğer ankaradan "*"farklıysa"*" diye okunur.
         #continue # sadece şartın o anki döngüsünü iptal ediyo ama sonrasında kaldığı yerden devamke.
        #break #döngüyü kırmayı sağlar ve devam etmez yani ankarayı verir ve işlemi bitirir.
       
        print(sehir + " için kod = " + sehir[0:3])    
        print("**********")
# if sehir == "Ankara":    
#%% For Range
for x in range(100):
    print(x) 
    print(x + 1)
#%% For Range 2
for x in range (1,10,2): #sonda kullanılan 2şer arttır demek default olarak 1 dir.
    print(x)
