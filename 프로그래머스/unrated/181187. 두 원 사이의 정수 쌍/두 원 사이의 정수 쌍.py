def solution(r1, r2):

    c=0
    
    p1=r1**2
    p2=r2**2

    y_min=r1
    y_max=r2
    for i in range(r2):
        while(y_max**2+i**2>p2):
            y_max=y_max-1
        while(y_min>1 and (y_min-1)**2+i**2>=p1 ):
            y_min=y_min-1
        c+=y_max-y_min+1
    
    
    return c*4