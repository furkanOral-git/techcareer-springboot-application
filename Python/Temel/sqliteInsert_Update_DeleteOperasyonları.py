import sqlite3


def insertCustomer ():
    connection = sqlite3.connect("chinook.db")
    connection.execute("""insert into Customers(firstName,lastName,city,email)
                           values('Furkan','Oral','Balıkesir','furkanoral@gmail.com')""")
    connection.commit()
    connection.close()

# insertCustomer()

### Update Operasyonuyla çalışma :
def updateCustomer ():
    connection =sqlite3.connect("chinook.db")
    connection.execute("""update customers set city='İstanbul'
                       where city='Balıkesir'""")
    connection.commit() 
    connection.close()                  
# updateCustomer()

### Delete Operasyonuyla Çalışma :

def deleteCustomer ():
    connection =sqlite3.connect("chinook.db")
    connection.execute("""delete from customers where customerid='1'""")
    connection.commit()
    connection.close()

#deleteCustomer()

### Join Operasyonlarıyla Çalışma :
def joinCustomer():
    connection =sqlite3.connect("chinook.db")
    connection.execute("""select albums.Title,artists.
                       Name from artists inner join albums on artists.
                       ArtistId = albums.ArtistId""")
    connection.commit()
    connection.close()
joinCustomer()  


