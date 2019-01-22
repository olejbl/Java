package encapsulation;

import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
	private String name;
	private String email;
	private Date birthDay;
	private char gender;
	private String[]  countryCodes = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
	
	public void setName(String name) {
		String[] split = name.split("\\s+");
		System.out.println(split);
		if (split.length == 2) {
			if (split[0].length() > 2 && split[1].length() > 2) {
				this.name = name;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public void setEmail(String email) {
		String[] splitAt = email.split("\\@");
		
		
		if (splitAt.length == 2) {
			String[] splitDot = splitAt[0].split("\\.");
			String[] splitName = name.split("\\s+");
			String[] splitDomain = splitAt[1].split("\\.");
			if (splitDot.length == 2 && splitDomain.length == 2 && splitName.length == 2) {
				if (splitDot[0].toLowerCase().compareTo(splitName[0].toLowerCase()) == 0 &&
					splitDot[1].toLowerCase().compareTo(splitName[1].toLowerCase()) == 0) {
					if (Arrays.asList(countryCodes).contains(splitDomain[1])) {
							this.email = email;
						}
						else {
							throw new IllegalArgumentException();
						}
				}
				else {
					throw new IllegalArgumentException();
				}
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		else {
			throw new IllegalArgumentException();
		}
		
		
		
		
	}
	
		
	
	
	//public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	//public static boolean validate(String email) {
	        //Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
	        //return matcher.find();
	//}
	public void setBirthday(Date date) {
		Date currentDate = new Date();
		if (date.before(currentDate)) {	
			birthDay = date;
		} else {
			throw new IllegalArgumentException();
		}
		
	}
	
	public void setGender(char gender) {
		if (gender == 'M' || gender == 'F' || gender == '\0') {
			this.gender = gender;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Date getBirthday() {
		return birthDay;
	}
	public char getGender() {
		return gender;
	}
	
	public String toString() {
        return "Name: " + name + "Email: " + email + " ";  //+validate(email);
    }	
	
	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("ole jacob");
		p1.setEmail("ole.jacob@jacob.co");
		System.out.println(p1);
	}

	

}
