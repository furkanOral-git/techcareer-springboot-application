# -*- coding: utf-8 -*-
#kullanıcıdan bir tane sayı girmesini isteyiniz
# sayı eğer 0 ise girdiğiniz sayı sıfırdır
# 0 dan büyük ise girdiğiniz sayı pozitif sayıdır
# 0 dan küçükse girdiğiniz sayı negatif sayıdır.

gırılenSayi = int(input("Sayı giriniz."))

if gırılenSayi<0:
    print("Girdiğiniz sayı negatif")
elif gırılenSayi>0:
    print("Girdiğiniz sayı pozitif")
else:
    print("Girdiğiniz sayı 0'dır")






