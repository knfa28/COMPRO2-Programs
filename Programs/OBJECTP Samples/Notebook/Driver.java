public class Driver
{
   public static void main( String[] args )
   {
      Notebook n = new Notebook( "Red", 10, 250 );
	  
	  Ballpen.write( n, "I am he as you are he as you are me and we are all t" +
	                    "ogether.\nSee how they run like pigs from a gun, see" +
						" how they fly.\nI'm crying.\nSitting on a cornflake," +
						" waiting for the van to come.\nCorporation tee-shirt" +
						", stupid bloody tuesday.\nMan, you been a naughty bo" +
						"y, you let your face grow long.\nI am the eggman, th" +
						"ey are the eggmen.\nI am the walrus, goo goo g'joob." +
						"\n\nMister city policeman sitting\nPretty little pol" +
						"icemen in a row.\nSee how they fly like Lucy in the " +
						"Sky, see how they run.\nI'm crying, I'm crying.\nI'm" +
						" crying, I'm crying.\n\nYellow mother custard, dripp" +
						"ing from a dead dog's eye.\nCrabalocker fishwife, po" +
						"rnographic priestess,\nBoy, you been a naughty girl " +
						"you let your knickers down.\nI am the eggman, they a" +
						"re the eggmen.\nI am the walrus, goo goo g'joob.\n\n" +
						"Sitting in an english garden waiting for the sun.\n" +
						"If the sun don't come, you get a tan\nFrom standing" +
						" in the english rain.\nI am the eggman, they are th" +
						"e eggmen.\nI am the walrus, goo goo g'joob goo goo " +
						"g'joob.\n\nExpert textpert choking smokers,\nDon't " +
						"you think the joker laughs at you?\nSee how they sm" +
						"ile like pigs in a sty,\nSee how they snied.\nI'm c" +
						"rying.\n\nSemolina pilchard, climbing up the eiffel " +
						"tower.\nElementary penguin singing Hari Krishna.\nMa" +
						"n, you should have seen them kicking edgar allan poe" +
						".\nI am the eggman, They are the eggmen.\nI am the w" +
						"alrus, goo goo g'joob goo goo g'joob goo goo g'joob." +
						"\nGoo goo g'joob goo" );
	 
	  for( int i = 1; i <= 10; i++ )
	  {
	     System.out.println( "Page " + i + ": " );
		 n.readPage( i );
		 System.out.println( "\n\n" );
	  }
		 
	  
	  Pencil.erase( n, 3, 100, 200 );
	  
	  n.readPage( 3 );
   }
}