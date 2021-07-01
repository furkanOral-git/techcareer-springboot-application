#%% select operasyonuyla
import sqlite3

connection = sqlite3.connect("chinook.db")

cursor = connection.execute("select FirstName,LastName from customers where city='Prague' order by FirstName")#order sırala demek.
# yukarda kullanılan * tümünü demek. yani tümünü seç dedik. where ile şart koyduk praglı olanları yaz dedik.
#tek tırnak içine almamızın sebebi ; tırnaksız python prague yi bir sütun gibi algılıyor tek tırnak içine alınca sabit bir değer olduğunu anladı.
for row in cursor:#row satır demek.
    print("First Name = " + row[0])
    print("Last Name = " + row[1])
    print("***************")
connection.close()    
#cursor imleç demek, execute yürüt demek, "commit" işle demek.
#%% Group By ve Having

import sqlite3
connection = sqlite3.connect("chinook.db")
cursor = connection.execute("""select city,count(*) from Customers group by city order by count(*) desc""")
#hangi şehirde kaç kişi var bunu gösteren kodumuz yukarda.
#descending = desc azalan sıraya göre desc yazmazsan otamatik tersine göre sıralar yani artan alfabe de dahil.
for row in cursor :
    print("City = " + row[0])
    print("Count = " + str(row[1]))
connection.close()
#%% Like Komutuyla çalışmak.

import sqlite3
connection = sqlite3.connect("chinook.db")
cursor = connection.execute("""select FirstName,LastName from Customers where FirstName like '%a%'""")
# like komutu gibi %a% ise içinde a bulunanlar % işareti önemli değil anlamına geliyor.
#yani %a% başı ve sonu önemli değil a bulunsun, eğer a% olsaydı başı a sonu önemli değil olacaktı.
for row in cursor:
    print("FirstName = " + row[0])
    print("LastName = " + row[1])
    print("************")
connection.close()



