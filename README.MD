# Tiny automation utility based on Java Robot.

Usage:
java -jar scripted_robot.jar script.txt

# Basic syntax
````
command arg1 arg2 arg3 arg4 arg5
````
Separator is exactly 1 space.

## Supported commands:

### Wait for pixe color
```
wait_pixel <x> <y> <r> <g> <b>
```
### Wait for delay in ms
```
wait <delay>
```
### Move mouse to x,y
```
mouse move <x> <y>
```

### Pres/release mouse button
```
mouse press <button> <state>
```

### Scroll mouse wheel for amount
```
mouse wheel <amount>
```

### Restart script
```
reset
```

### Press/release keyboard key with VK CODE
```
keyboard <vk_code> <state>
```