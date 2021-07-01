fileToAppend = open("ogrenciler.txt","a")

ogrenciler=["ali","ayse","fatma","mert","furkan"]

for ogrenci in ogrenciler :
    fileToAppend.write(ogrenci) 
    fileToAppend.write("\n")

fileToAppend.close()    
#dosya üstünde işlem yaptıktan sonra işlemin tamamlanması için mutlaka kapatman gerekli.




