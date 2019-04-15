library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
--use IEEE.NUMERIC_STD.ALL;
--use UNISIM.VComponents.all;

entity CarParkingSystem is
	port ( FRONT, BACK : in std_logic; -- senzori
			 PASSWORD : in std_logic; -- 1 = tacan, 0 = netacan
			 CLK : in std_logic;
			 RESET : in std_logic; -- vraca na pocetno stanje
			 ZELENO, CRVENO : out std_logic );
end CarParkingSystem;

architecture Behavioral of CarParkingSystem is
type STANJE_tip is (IDLE, WAIT_PASSWORD, RIGHT_PASSWORD, WRONG_PASSWORD, STOP);
signal sadasnje_stanje, sledece_stanje : STANJE_tip;
begin

process(sadasnje_stanje, FRONT, BACK)
begin
	case sadasnje_stanje is
		when IDLE =>
			CRVENO <= '0';
			ZELENO <= '0';
			if (FRONT = '1') then
				sledece_stanje <= WAIT_PASSWORD;
			else
				sledece_stanje <= IDLE;
			end if;
			
		when WAIT_PASSWORD =>
			CRVENO <= '0';
			ZELENO <= '0';
			if (PASSWORD = '1') then
				sledece_stanje <= RIGHT_PASSWORD;
			else
				sledece_stanje <= WRONG_PASSWORD;
			end if;
			
		when RIGHT_PASSWORD =>
			CRVENO <= '0';
			ZELENO <= '1';
			if (FRONT = '1' and BACK = '1') then
				sledece_stanje <= STOP;
			elsif (BACK = '0') then
				sledece_stanje <= RIGHT_PASSWORD;
			else
				sledece_stanje <= IDLE;
			end if;
			
		when WRONG_PASSWORD =>
			CRVENO <= '1';
			ZELENO <= '0';
			if (PASSWORD = '1') then
				sledece_stanje <= RIGHT_PASSWORD;
			else
				sledece_stanje <= WRONG_PASSWORD;
			end if;
			
		when STOP =>
			CRVENO <= '1';
			ZELENO <= '0';
			if (PASSWORD = '1') then
				sledece_stanje <= RIGHT_PASSWORD;
			else
				sledece_stanje <= STOP;
			end if;
	end case;
			
end process;

process(CLK)
variable brojac : integer := 0;
begin
	if (rising_edge(CLK)) then
		if (RESET = '1') then
			sadasnje_stanje <= IDLE;
		else
			if (sadasnje_stanje = WAIT_PASSWORD) then
				if (brojac = 3) then
					brojac := 0;
					sadasnje_stanje <= sledece_stanje;
				else
					brojac := brojac + 1;
				end if;
			else
				sadasnje_stanje <= sledece_stanje;
			end if;
		end if;
	end if;
end process;


end Behavioral;

