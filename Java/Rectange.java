class Rectangle extends Shape{
		
	private double width,length;

	public Rectangle(){
		super();
		width = length = 1.0;
	}

	public Rectangle(double width, double length){
		super();
		this.width = width; this.length = length;
	}

 	public Rectangle(double width, double length,String color, boolean filled){
		super(color,filled);
		this.width = width; this.length = length;
	}

	public double getWidth(){
		return this.width;
	}

	public void setWidth(double width){
		this.width = width;
	}

	public double getLength(){
		return this.length;
	}

	public void setLength(double length){
		this.length = length;
	}
	
	public double getArea(){
		return this.width * this.length;
	}	

	public double getPerimeter(){
		return 2 * this.width + 2 * this.length;
	}
	
	@Override
	public String toString(){
		return "A Rectangle with width=" + this.width + " and length=" + this.length + ", which is a subclass of " + super.toString();
	}

}

