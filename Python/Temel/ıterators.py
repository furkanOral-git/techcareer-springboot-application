#iterasyon elinizdeki listenin
#(tuple,dict,sets hepsi olur) elemanlarını 
#tek tek dolaşma yöntemidir.

liste = ["Ankara","İstanbul","İzmir"]

iteratorum = iter(liste)

print(next(iteratorum)) #1.bunda hep Ankarayı çalıştırcak.
print(next(iteratorum)) #2. nextte İstanbul yani 2.elaman
print(next(iteratorum)) #3.nextte İzmir yani 3. elaman.

#for fonksiyonu bir iteratördür. 
#Bu çalışma ise yapı taşıdır for döngüsünün.







