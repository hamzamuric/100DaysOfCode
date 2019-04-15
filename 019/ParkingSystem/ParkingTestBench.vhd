LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
--USE ieee.numeric_std.ALL;
 
ENTITY ParkingTestBench IS
END ParkingTestBench;
 
ARCHITECTURE behavior OF ParkingTestBench IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT CarParkingSystem
    PORT(
         FRONT : IN  std_logic;
         BACK : IN  std_logic;
         PASSWORD : IN  std_logic;
         CLK : IN  std_logic;
         RESET : IN  std_logic;
         ZELENO : OUT  std_logic;
         CRVENO : OUT  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal FRONT : std_logic := '0';
   signal BACK : std_logic := '0';
   signal PASSWORD : std_logic := '0';
   signal CLK : std_logic := '0';
   signal RESET : std_logic := '0';

 	--Outputs
   signal ZELENO : std_logic;
   signal CRVENO : std_logic;

   -- Clock period definitions
   constant CLK_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: CarParkingSystem PORT MAP (
          FRONT => FRONT,
          BACK => BACK,
          PASSWORD => PASSWORD,
          CLK => CLK,
          RESET => RESET,
          ZELENO => ZELENO,
          CRVENO => CRVENO
        );

   -- Clock process definitions
   CLK_process :process
   begin
		CLK <= '0';
		wait for CLK_period/2;
		CLK <= '1';
		wait for CLK_period/2;
   end process;
 

   -- Stimulus process
   stim_proc: process
   begin		
      -- hold reset state for 100 ns.
      -- wait for 10 ns;
		
		FRONT    <= '0';
		BACK     <= '0';
		PASSWORD <= '0';
		RESET    <= '0';

      wait for CLK_period;

		-- dosao je novi auto i ne unosi tacan password
		FRONT    <= '1';
		BACK     <= '0';
		PASSWORD <= '0';
		RESET    <= '0';
		
		wait for CLK_period*5;
		
		-- unosi tacan password (u stanju wrong_password)
		-- prelazi u right_password
		FRONT    <= '0';
		BACK     <= '0';
		PASSWORD <= '1';
		RESET    <= '0';
		
		wait for CLK_period;
		
		-- dosao je jos jedan auto, stanje stop
		-- unosi pogresan password
		FRONT    <= '1';
		BACK     <= '1';
		PASSWORD <= '0';
		RESET    <= '0';
		
		wait for CLK_period;
		
		-- novi auto unosi tacan password
		FRONT    <= '0';
		BACK     <= '1';
		PASSWORD <= '1';
		RESET    <= '0';
		
		wait for CLK_period;
		
		-- nema novih automobila, stanje idle
		FRONT    <= '0';
		BACK     <= '1';
		PASSWORD <= '0';
		RESET    <= '0';
		
		wait for CLK_period;
		
		FRONT    <= '0';
		BACK     <= '0';
		PASSWORD <= '0';
		RESET    <= '0';

      wait;
   end process;

END;
