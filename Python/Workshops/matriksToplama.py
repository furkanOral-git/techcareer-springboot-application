
# 1 3 5
# 2 4 1
# 1 5 7

# 2 3 4
# 2 4 1
# 3 5 4


x= [ [1,3,5],[2,4,1],[1,5,7] ]
y = [ [2,3,4],[2,4,1],[3,5,4] ]
sonuc = [[0,0,0],[0,0,0],[0,0,0]]

for i in range(len(x)):
    for j in range(len(y)):
        sonuc[i][j] = x[i][j] + y[i][j]

print(sonuc)








