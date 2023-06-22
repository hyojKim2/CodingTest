def move(dirr): #이동함수
    dx=[-1, 1, 0,0] #상하좌우NSWE 
    dy=[0,0,-1,1]
    if dirr=="N":
        return dx[0],dy[0]
    elif dirr=="S":
        return dx[1],dy[1]
    elif dirr=="W":
        return dx[2],dy[2]
    else:
        return dx[3],dy[3]
    
def solution(park, routes):
    
    start_x=0
    start_y=0
    for i in range(len(park)): #시작점을 찾음
        for k in range(len(park[i])):
            if park[i][k]=='S':
                start_x=i
                start_y=k
                break
    
    x=start_x
    y=start_y
    for i in range(len(routes)):
        dx, dy=move(routes[i][0])
        mult=int(routes[i][2])
        x_ori=x
        y_ori=y
        for i in range(mult):
            if((x+dx)<len(park) and (y+dy)<len(park[i])and 
              (x+dx)>=0 and (y+dy) >=0):
                if(park[x+dx][y+dy]!='X'):
                    x+=dx
                    y+=dy
                else: #X만난경우
                    x=x_ori
                    y=y_ori
                    break
            else:
                x=x_ori
                y=y_ori
                break
                    
            
            
        
    #배열크기체크 
    # 장애물x체크 블럭의 원소 체크
    
    
    return x, y