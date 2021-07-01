#%% class basic:
class Matematik :
   
    def topla(self,sayi1,sayi2):
        return sayi1 + sayi2
    def cikar(self,sayi1,sayi2):
        return sayi1 - sayi2
    def carp(self,sayi1,sayi2):
        return sayi1 * sayi2
    def bol(self,sayi1,sayi2):
        return sayi1 / sayi2
#fonksiyonları bir classın içinde topladıysanız
# parametrelerin başına "self" deyimini bırakınız.
#yoksa çalışmayacaktır.
matematik = Matematik()

print("toplam = "+ str(matematik.topla(2,78)))
#%%
class Matematik :
    def __init__(self,sayi1,sayi2):
        self.sayi1 = sayi1
        self.sayi2 = sayi2 #globelde değer vermişsin gibi
    
    def topla(self):
        self.__class__(sayi1, sayi2)#nesneye ulaşmak için kullanılmıcak.
        return self.sayi1 + self.sayi2

matematik = Matematik(2,78)
print(str(matematik.topla()))
#%% property (özellik)

class Person:
   def __init__(self,firstName,lastName,age) :
       self.firstName = firstName
       self.lastName = lastName
       self.age = age

person1 = Person("Furkan", "Oral", 20)
print(person1.firstName)       
#%% İnheritance(miras) classlar arası:
class Person :
    def __init__(self,firstName,lastName,age):
        self.firstName = firstName
        self.lastName = lastName
        self.age = age
class Worker(Person) : #**
    def __init__(self,salary):
        self.salary = salary
class Customer(Person) : #**
    def __init__(self,creditCardNumber):
        self.creditCardNumber = creditCardNumber        
ahmet = Worker()
mehmet = Customer()
mehmet.firstName 
ahmet.firstName #ahmeti worker olarak tanıtmamıza rağmen persondaki firstnameni görebiliyoruz
# buna inheritance diyoruz.






