extends Area2D;

@export var speed = 500;
var screenSize;

# Called when the node enters the scene tree for the first time.
func _ready() -> void:
	screenSize = get_viewport_rect().size; # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta: float) -> void:
	var velocity = Vector2.ZERO;
	if(Input.is_action_pressed("moveUp")):
		velocity.y -= 1;
	if(Input.is_action_pressed("moveDown")):
		velocity.y += 1;
	if(Input.is_action_pressed("moveRight")):
		velocity.x += 1;
	if(Input.is_action_pressed("moveLeft")):
		velocity.x -= 1;
	position += velocity.normalized() * delta * speed;
	position = position.clamp(Vector2.ZERO, screenSize);
