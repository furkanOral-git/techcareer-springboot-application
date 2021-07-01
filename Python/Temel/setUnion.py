# -*- coding: utf-8 -*-

setA = {1,2,3,4}
setB = {4,5,6,7}

#union
print(setA | setB) #pipe işareti    
# ya da
print(setA.union(setB))
# ya da
print(setB.union(setA))

#intersection kesişim kümesini bulmanı sağlar

print(setA & setB) # "&" "and=ve" oparatörü.
# ya da
print(setA.intersection(setB))
# ya da
print(setB.intersection(setA))

# "difference" "-" çıkarma oparatörü
print(setA - setB)#sadece A, kesişim atıldı.
print(setB - setA)#sadece B, kesişim atıldı.
print(setA.difference(setB))
print(setB.difference(setA))

#symmetric_difference
#A-B ve B-A nın birleşim kümesi yani kesişim sayılmadan
#farklı olan elamanlar birleştirilir.

print(setA ^ setB) # "^"  oparatörü.
# ya da
print(setA.symmetric_difference(setB))
# ya da
print(setB.symmetric_difference(setA))












