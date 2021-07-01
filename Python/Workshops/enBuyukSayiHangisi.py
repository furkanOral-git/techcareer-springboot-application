# -*- coding: utf-8 -*-
# kullanıcıdan 3 tane sayı isteyeceksiniz tam sayı olsun.
# girdiği sayılardan hangisi en büyük ise 
# ekranda o sayıya en büyük sayı budur desin.

list = [int(input("1.Sayıyı Giriniz")),
        int(input("2.Sayıyı giriniz")),
        int(input("3.Sayıyı giriniz"))]

if list[0] > list[1] and list[0]> list[2]:
    print(str(list[0]) + " En Büyük Sayınızdır.")
elif list[0] < list[1] and list[0] < list[2]:
    print(str(list[0])+ " En Küçük Sayınızdır")

    
if list[1] > list[0] and list[1]> list[2]:
    print(str(list[1]) + " En Büyük Sayınızdır.")

elif list[1] < list[0] and list[1] < list[2]:
    print(str(list[1]) + " En Küçük sayınızdır")

    
if list[2] > list[1] and list[2]> list[0]:
    print(str(list[2]) + " En Büyük Sayınızdır.")
elif:
    print(str[list[2]] + " En Küçük Sayınızdır")


print(list)



