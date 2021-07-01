import json

data  = '{"firstName":"Furkan","lastName":"Oral"}'

y = json.loads(data)
#datayı string iken json formatına çevirdik. 
#"json.loads"

print(y["firstName"])
print(y["lastName"])

customer = {
    "firstName":"Furkan",
    "email":"furkanoral@gmail.com"
            }#dictionary

customerJson = json.dumps(customer)
print(customer)
#python nesnelerini jsona çeirirken
#json.dumps kullanılır.  